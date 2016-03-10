package com.github.droibit.plugin.truth.postfix.utils

import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.idea.caches.resolve.ModuleTestSourceInfo
import org.jetbrains.kotlin.idea.caches.resolve.getNullableModuleInfo
import org.jetbrains.kotlin.psi.KtElement
import org.jetbrains.kotlin.psi.KtImportsFactory
import org.jetbrains.kotlin.resolve.ImportPath

internal val TRUTH_CLASS_NAME = "com.google.common.truth.Truth"

internal fun getTemplateStringIfWithinTestModule(element: PsiElement, template: String): String? {
    return if (withinTestModule(element)) template else null
}

internal fun withinTestModule(element: PsiElement) = element.getNullableModuleInfo() is ModuleTestSourceInfo

internal fun resolveStaticMethod(element: PsiElement, className: String, methodName: String): String? {
    val file = (element as? KtElement)?.getContainingKtFile() ?: return null

    val importDirectives = file.importDirectives
    for (id in importDirectives) {
        val fqName = id.importedFqName?.asString() ?: continue

        if (!fqName.startsWith(className)) {
            continue
        }
        if (fqName.endsWith("*") || fqName.endsWith(methodName)) {
            return methodName
        }
    }

    val factory = KtImportsFactory(element.project)
    val newImportDirective = factory.createImportDirective(ImportPath("$className.$methodName"))
    val anchor = if (importDirectives.isNotEmpty()) importDirectives.last() else file.firstChild
    file.addAfter(newImportDirective, anchor)

    return methodName
}