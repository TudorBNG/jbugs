import exeptions.BusinessExceptionMapper;
import exeptions.RuntimeExceptionMapper;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */

@ApplicationPath("jbugs-api")
public class JBugsApplication extends Application {


    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();

        classes.add(BusinessExceptionMapper.class);
        classes.add(RuntimeExceptionMapper.class);

        return super.getClasses();
    }

    @Override
    public Set<Object> getSingletons() {
        Set<Object> set = new HashSet<>();
        set.add(new JacksonJsonProvider());
        return super.getSingletons();
    }



}
