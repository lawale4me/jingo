
package com.bytecode.jingo.client;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author Ahmed
 */
@ApplicationPath("/api")
public class JingoApplication extends Application
{
     private final Set<Class<?>> empty = new HashSet<>();
    private Set<Object> singletons = new HashSet<>();

    @Override
    public Set<Class<?>> getClasses()
    {
        return empty;
    }

    @Override
    public Set<Object> getSingletons()
    {
        return singletons;
    }
}
