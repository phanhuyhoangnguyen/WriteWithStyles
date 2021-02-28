/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import enumclass.FormStageType;
import javax.faces.component.UIComponent;

public abstract class FormController {

    protected UIComponent formComponent;

    public UIComponent getFormComponent() {
        return formComponent;
    }

    public void setFormComponent(UIComponent formComponent) {
        this.formComponent = formComponent;
    }
    
    protected String formOutputMessageHeading;
    protected String formOutputMessageBody;
    
    protected FormStageType stage = FormStageType.Undefined;

    protected final String SUCCESS = "SUCCESS";

    public String getFormOutputMessageHeading() {
        return formOutputMessageHeading;
    }

    public String getFormOutputMessageBody() {
        return formOutputMessageBody;
    }
    
    public abstract void submit();

    public FormStageType getStage() {
        return stage;
    }

    public void setStage(FormStageType stage) {
        this.stage = stage;
    }

    public boolean isSubmittedFormValid() {
        return stage == FormStageType.Success;
    }

}
