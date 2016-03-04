package com.github.droibit.plugin.truth.postfix.utils

import com.intellij.openapi.util.Condition
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiExpression
import com.intellij.psi.PsiType
import com.intellij.psi.util.InheritanceUtil

private val JAVA_LANG_CHAR_SEQUENCE = "java.lang.CharSequence"
private val TRUTH_SUBJECT_FACTORY = "com.google.common.truth.SubjectFactory"

private val PsiElement.type: PsiType?
    get() = if (this is PsiExpression) type else null

internal val IS_CHAR_SEQUENCE = Condition<PsiElement> { e ->
    InheritanceUtil.isInheritor(e.type, JAVA_LANG_CHAR_SEQUENCE)
}

internal val IS_SUBJECT_FACTORY = Condition<PsiElement> {e ->
    InheritanceUtil.isInheritor(e.type, TRUTH_SUBJECT_FACTORY)
}