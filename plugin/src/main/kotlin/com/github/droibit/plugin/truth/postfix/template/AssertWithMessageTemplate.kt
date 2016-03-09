package com.github.droibit.plugin.truth.postfix.template

import com.github.droibit.plugin.truth.postfix.template.selector.JavaSelectorConditions.IS_CHAR_SEQUENCE
import com.intellij.codeInsight.template.Template
import com.intellij.codeInsight.template.TemplateManager
import com.intellij.codeInsight.template.postfix.templates.StringBasedPostfixTemplate
import com.intellij.codeInsight.template.postfix.util.JavaPostfixTemplatesUtils.selectorTopmost
import com.intellij.psi.PsiElement

/**
 * @author kumagai
 */
class AssertWithMessageTemplate : StringBasedPostfixTemplate(
        "assertWithMessage",
        "assertWithMessage(expr)",
        selectorTopmost(IS_CHAR_SEQUENCE)) {

    override fun createTemplate(manager: TemplateManager, templateString: String): Template {
        return super.createTemplate(manager, templateString).apply {
            isToReformat = shouldReformat()
            setValue(Template.Property.USE_STATIC_IMPORT_IF_POSSIBLE, true)
        }
    }

    override fun getTemplateString(psiElement: PsiElement): String {
        return "com.google.common.truth.Truth.assertWithMessage(\$expr\$)\$END\$"
    }
}
