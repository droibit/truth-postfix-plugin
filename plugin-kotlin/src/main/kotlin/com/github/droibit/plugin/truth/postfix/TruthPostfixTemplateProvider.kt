package com.github.droibit.plugin.truth.postfix

import com.intellij.codeInsight.template.postfix.templates.PostfixTemplate
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplateProvider
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile

/**
 * @author kumagai
 */
class TruthPostfixTemplateProvider : PostfixTemplateProvider {

    private val templates: Set<PostfixTemplate>

    constructor() {
        templates = hashSetOf()
    }

    override fun getTemplates() = templates

    override fun isTerminalSymbol(currentChar: Char) = currentChar == '.' || currentChar == '!'

    override fun afterExpand(file: PsiFile, editor: Editor) { }

    override fun preCheck(copyFile: PsiFile, realEditor: Editor, currentOffset: Int) = copyFile

    override fun preExpand(file: PsiFile, editor: Editor) { }
}