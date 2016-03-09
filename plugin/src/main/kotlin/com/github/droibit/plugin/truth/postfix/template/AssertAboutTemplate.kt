package com.github.droibit.plugin.truth.postfix.template

import com.github.droibit.plugin.truth.postfix.template.selector.JavaSelectorConditions.IS_SUBJECT_FACTORY
import com.github.droibit.plugin.truth.postfix.utils.TRUTH_CLASS_NAME
import com.github.droibit.plugin.truth.postfix.utils.getTemplateStringIfWithinTestModule
import com.intellij.codeInsight.template.Template
import com.intellij.codeInsight.template.Template.Property.USE_STATIC_IMPORT_IF_POSSIBLE
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
            setValue(USE_STATIC_IMPORT_IF_POSSIBLE, true)
        }
    }

    override fun getTemplateString(psiElement: PsiElement): String? {
        return getTemplateStringIfWithinTestModule(element = psiElement,
                                                   template = "$TRUTH_CLASS_NAME.assertAbout(\$expr\$).that(\$target\$)\$END\$")
    }

    override fun setVariables(template: Template, element: PsiElement) {
        template.addVariable("target", MacroCallNode(SuggestVariableNameMacro()), false)
    }
}