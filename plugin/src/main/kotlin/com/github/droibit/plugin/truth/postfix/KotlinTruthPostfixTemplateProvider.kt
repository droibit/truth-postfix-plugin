package com.github.droibit.plugin.truth.postfix

import com.github.droibit.plugin.truth.postfix.template.KotlinAssertThatTemplate
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplate
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplateProvider
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile

/**
 * @author kumagai
 */
class KotlinTruthPostfixTemplateProvider : PostfixTemplateProvider {

    private val templates: Set<PostfixTemplate>

    constructor() {
        templates = hashSetOf(
                KotlinAssertThatTemplate()
        )
    }

    override fun getTemplates() = templates

    override fun isTerminalSymbol(currentChar: Char) = currentChar == '.' || currentChar == '!'

    override fun afterExpand(file: PsiFile, editor: Editor) { }

    override fun preCheck(copyFile: PsiFile, realEditor: Editor, currentOffset: Int) = copyFile

    override fun preExpand(file: PsiFile, editor: Editor) { }
}