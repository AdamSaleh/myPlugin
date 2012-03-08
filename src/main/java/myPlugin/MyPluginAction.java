// Even a warning example, is an example. :-X

package myPlugin;


import hudson.model.AbstractProject;
import hudson.model.ProminentProjectAction;

public class MyPluginAction  implements ProminentProjectAction 
{
    private boolean escapeTestDescp;
    private boolean escapeExceptionMsg;
    
    public MyPluginAction(AbstractProject<?, ?> project) 
    {
    	  this.project = project;
      this.escapeExceptionMsg = escapeExceptionMsg;
      this.escapeTestDescp = escapeTestDescp;
    }

     /**
    * The owner of this action.
    */
   private final AbstractProject<?, ?> project;

   /**
    * Getter for property 'project'.
    *
    * @return Value for property 'project'.
    */
   public AbstractProject<?, ?> getProject() {
      return project;
   }
    
    public String getIconFileName() {
        return  PluginImpl.ICON_FILE_NAME;
    }

    public String getDisplayName() {
        return  PluginImpl.DISPLAY_NAME;
    }

    public String getUrlName() {
        return  PluginImpl.URL;
    }

  
}

