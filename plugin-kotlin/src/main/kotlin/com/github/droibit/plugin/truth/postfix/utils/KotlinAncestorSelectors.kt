package com.github.droibit.plugin.truth.postfix.utils

import com.intellij.codeInsight.template.postfix.templates.PostfixTemplateExpressionSelectorBase
import com.intellij.openapi.editor.Document
import com.intellij.openapi.util.Condition
import com.intellij.openapi.util.Conditions
import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.psi.KtExpression

/**
 *  * [AncestorSelector.scala](https://goo.gl/2c7ZJl)
 *  * [ScalaPsiUtil.scala](https://goo.gl/bVBMGk)
 */
internal object KotlinAncestorSelectors {

    fun selectorTopmost(condition: Condition<PsiElement>) = object: PostfixTemplateExpressionSelectorBase(condition) {

        override fun getFilters(offset: Int) = Conditions.and(super.getFilters(offset), psiErrorFilter)

        override fun getNonFilteredExpressions(context: PsiElement, document: Document, offset: Int): List<PsiElement> {
            val element = context.parentOfType(KtExpression::class.java)
            return when (element) {
                is KtExpression -> {
                    val result = arrayListOf(element)
                    var current = element.parent
                    while (current != null &&
                           current.textRange != null &&
                           current.textRange.endOffset <= offset &&
                           current is KtExpression) {
                        result.add(current)
                        current = current.parent
                    }
                    result
                }
                else -> emptyList()
            }
        }
    }
}

/**
 * [SelectorConditions.scala](https://goo.gl/Rf8Qp9)
 * [ScExpression.scala](https://goo.gl/a8EUD9)
 */
internal object KotlinSelectorConditions {

    val ANY_EXPR = Condition<PsiElement> {
        it is KtExpression
    }
}

private fun PsiElement.parentOfType(vararg classes: Class<out PsiElement>): PsiElement {
    var current = this
    while (current != null && classes.find { it.isInstance(current) } == null) {
        current = current.parent
    }
    return current
}