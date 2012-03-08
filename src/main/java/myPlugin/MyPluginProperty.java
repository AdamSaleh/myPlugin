/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myPlugin;

import hudson.Extension;
import hudson.model.*;
import java.util.Collection;
import java.util.Collections;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

/**
 *
 * @author asaleh
 */
public class MyPluginProperty extends
        JobProperty<AbstractProject<?, ?>>{
    
    /**
     * This will the URL to the project main branch.
     */
    private String projectUrl;

    @DataBoundConstructor
    public MyPluginProperty(String projectUrl) {
        this.projectUrl = projectUrl;
    }
    @Override
    public Collection<? extends Action> getJobActions(AbstractProject<?, ?> job) {
        return Collections.singleton(new MyPluginAction(job));
    }
    @Extension
    public static final class DescriptorImpl extends JobPropertyDescriptor {

        public DescriptorImpl() {
            super(MyPluginProperty.class);
            load();
        }

        public boolean isApplicable(Class<? extends Job> jobType) {
            return AbstractProject.class.isAssignableFrom(jobType);
        }

        public String getDisplayName() {
            return "GitHub project page";
        }

        @Override
        public JobProperty<?> newInstance(StaplerRequest req,
                JSONObject formData) throws FormException {
            MyPluginProperty tpp = req.bindJSON(
                    MyPluginProperty.class, formData);
            if (tpp.projectUrl == null) {
                tpp = null; // not configured
            }
            return tpp;
        }

    }
}
