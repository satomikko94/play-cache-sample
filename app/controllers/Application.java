package controllers;

import model.Task;
import play.*;
import play.cache.Cache;
import play.data.Form;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    static Form<Task> taskFrom = Form.form(Task.class);

    public Result tasks() {
    	return ok(setCache.render(taskFrom));
    }
    
    public Result setCacheData() {
        Form<Task> filledForm = taskFrom.bindFromRequest();
        Task task = filledForm.get();

        Cache.set("task", task, 60 * 1);
        return ok(setCache.render(filledForm));
    }

}
