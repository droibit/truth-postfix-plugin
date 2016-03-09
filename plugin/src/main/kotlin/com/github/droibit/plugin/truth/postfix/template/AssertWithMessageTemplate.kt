package com.github.droibit.plugin.truth.postfix.template

import com.github.droibit.plugin.truth.postfix.template.selector.JavaSelectorConditions.IS_CHAR_SEQUENCE
import com.github.droibit.plugin.truth.postfix.utils.TRUTH_CLASS_NAME
import com.github.droibit.plugin.truth.postfix.utils.getTemplateStringIfWithinTestModule
import com.intellij.codeInsight.template.Template
import com.intellij.codeInsight.template.Template.Property.USE_STATIC_IMPORT_IF_POSSIBLE
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
            setValue(USE_STATIC_IMPORT_IF_POSSIBLE, true)
        }
    }

    override fun getTemplateString(psiElement: PsiElement): String? {
        return getTemplateStringIfWithinTestModule(element = psiElement,
                                                   template = "$TRUTH_CLASS_NAME.assertWithMessage(\$expr\$)\$END\$")
    }
}
