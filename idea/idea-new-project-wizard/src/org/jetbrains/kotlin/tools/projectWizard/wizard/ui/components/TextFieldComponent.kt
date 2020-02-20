package org.jetbrains.kotlin.tools.projectWizard.wizard.ui.components

import com.intellij.ui.components.JBTextField
import org.jetbrains.kotlin.tools.projectWizard.core.ReadingContext
import org.jetbrains.kotlin.tools.projectWizard.core.entity.SettingValidator
import org.jetbrains.kotlin.tools.projectWizard.wizard.ui.textField

class TextFieldComponent(
    readingContext: ReadingContext,
    labelText: String? = null,
    initialValue: String? = null,
    validator: SettingValidator<String>? = null,
    onValueUpdate: (String) -> Unit = {}
) : UIComponent<String>(
    readingContext,
    labelText,
    validator,
    onValueUpdate
) {
    override val uiComponent: JBTextField = textField(initialValue.orEmpty(), ::fireValueUpdated)

    override fun updateUiValue(newValue: String) = safeUpdateUi {
        uiComponent.text = newValue
    }

    override fun getUiValue(): String = uiComponent.text
}