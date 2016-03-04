package com.github.droibit.plugin.truth.postfix.template

import com.intellij.codeInsight.template.Template
import com.intellij.codeInsight.template.Template.Property.USE_STATIC_IMPORT_IF_POSSIBLE
import com.intellij.codeInsight.template.TemplateManager
import com.intellij.codeInsight.template.postfix.templates.StringBasedPostfixTemplate
import com.intellij.codeInsight.template.postfix.util.JavaPostfixTemplatesUtils.*
import com.intellij.psi.PsiElement

/**
 * Created by kumagai on 2016/03/04.
 */
class AssertThatTemplate : StringBasedPostfixTemplate(
        "assertThat",
        "assertThat(expr)",
        selectorAllExpressionsWithCurrentOffset(IS_NON_VOID)) {

    override fun createTemplate(manager: TemplateManager, templateString: String): Template {
        return super.createTemplate(manager, templateString).apply {
            isToReformat = true
            setValue(USE_STATIC_IMPORT_IF_POSSIBLE, true)
        }
    }

    override fun getTemplateString(psiElement: PsiElement): String {
       return "com.google.common.truth.assertThat(assertThat(\$expr\$)\$END\$"
    }
}