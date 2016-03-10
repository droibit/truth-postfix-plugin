package com.github.droibit.plugin.truth.postfix.template

import com.github.droibit.plugin.truth.postfix.template.selector.KotlinAncestorSelectors.selectorTopmost
import com.github.droibit.plugin.truth.postfix.template.selector.KotlinSelectorConditions.ANY_EXPR
import com.github.droibit.plugin.truth.postfix.utils.*
import com.intellij.codeInsight.template.Template
import com.intellij.codeInsight.template.TemplateManager
import com.intellij.codeInsight.template.postfix.templates.StringBasedPostfixTemplate
import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.psi.KtElement

/**
 * @author kumagai
 */
class KotlinAssertThatTemplate : StringBasedPostfixTemplate(
        "assertThat",
        "assertThat(expr)",
        selectorTopmost(ANY_EXPR)) {

    // Ref: https://goo.gl/jpjA7w
    override fun getElementToRemove(expr: PsiElement) = expr

    override fun createTemplate(manager: TemplateManager, templateString: String): Template {
        return super.createTemplate(manager, templateString).apply {
            isToReformat = shouldReformat()
        }
    }

    override fun getTemplateString(psiElement: PsiElement): String? {
        if (!withinTestModule(element = psiElement)) {
            return null
        }

        val methodName = resolveStaticMethod(element = psiElement,
                                             className = TRUTH_CLASS_NAME,
                                             methodName = "assertThat")
        return if (methodName != null) "$methodName(\$expr\$)\$END\$" else null
    }
}