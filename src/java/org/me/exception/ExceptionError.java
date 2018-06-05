package org.me.exception;


public class ExceptionError extends Exception{
    
    private String code;
    private String message;
    private String appName;
    private String appOrganization;
       
    
    public ExceptionError() {
    }

    public ExceptionError(String code, String message, String appName, String appOrganization) {
        this.code = code;
        this.message = message;
        this.appName = appName;
        this.appOrganization = appOrganization;
    }

    public ExceptionError(Exception error) {
        LibraryError codeError = new LibraryError();
        
        this.setCode("");
        this.setMessage(error.getMessage());
        this.setAppName(codeError.Application);
        this.setAppOrganization(codeError.Organization);
    }
    
    
    public ExceptionError(ExceptionError error) {
        this.setCode(error.getCode());
        this.setMessage(error.getMessage());
        this.setAppName(error.getAppName());
        this.setAppOrganization(error.getAppOrganization());
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppOrganization() {
        return appOrganization;
    }

    public void setAppOrganization(String appOrganization) {
        this.appOrganization = appOrganization;
    }

    
}
