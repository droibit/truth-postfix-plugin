package com.github.droibit.plugin.truth.postfix.utils

import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.idea.caches.resolve.ModuleTestSourceInfo
import org.jetbrains.kotlin.idea.caches.resolve.getNullableModuleInfo

internal val TRUTH_CLASS_NAME = "com.google.common.truth.Truth"

internal fun getTemplateStringIfWithinTestModule(element: PsiElement, template: String): String? {
    return if (element.getNullableModuleInfo() is ModuleTestSourceInfo) template else null
}