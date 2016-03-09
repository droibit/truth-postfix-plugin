package com.github.droibit.plugin.truth.postfix.template

import com.github.droibit.plugin.truth.postfix.template.selector.JavaSelectorConditions.IS_SUBJECT_FACTORY
import com.intellij.codeInsight.template.Template
import com.intellij.codeInsight.template.TemplateManager
import com.intellij.codeInsight.template.impl.MacroCallNode
import com.intellij.codeInsight.template.macro.SuggestVariableNameMacro
import com.intellij.codeInsight.template.postfix.templates.StringBasedPostfixTemplate
import com.intellij.codeInsight.template.postfix.util.JavaPostfixTemplatesUtils.selectorTopmost
import com.intellij.psi.PsiElement

/**
 * @author kumagai
 */
class AssertAboutTemplate : StringBasedPostfixTemplate(
        "assertAbout",
        "assertAbout(expr).that(target)",
        selectorTopmost(IS_SUBJECT_FACTORY)) {

    override fun createTemplate(manager: TemplateManager, templateString: String): Template {
        return super.createTemplate(manager, templateString).apply {
            isToReformat = shouldReformat()
            setValue(Template.Property.USE_STATIC_IMPORT_IF_POSSIBLE, true)
        }
    }

    override fun getTemplateString(psiElement: PsiElement): String {
        return "com.google.common.truth.Truth.assertAbout(\$expr\$).that(\$target\$)\$END\$"
    }

    override fun setVariables(template: Template, element: PsiElement) {
        template.addVariable("target", MacroCallNode(SuggestVariableNameMacro()), false)
    }
}