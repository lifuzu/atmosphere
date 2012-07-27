/*
 * Copyright 2012 Jeanfrancois Arcand
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.atmosphere.cpr;

/**
 * A Simple {@link AtmosphereInterceptor} that creates an {@link AtmosphereInterceptorWriter} and set it as
 * the default {@link AsyncIOWriter} on an {@link AtmosphereResponse}
 *
 * @author Jeanfrancois Arcand
 */
public abstract class AtmosphereInterceptorAdapter implements AtmosphereInterceptor {
    @Override
    public void configure(AtmosphereConfig config) {
    }

    @Override
    public Action inspect(AtmosphereResource r) {
        AtmosphereResponse res = r.getResponse();
        if (res.getAsyncIOWriter() == null) {
            res.asyncIOWriter(new AtmosphereInterceptorWriter(res));
        }
        return Action.CONTINUE;
    }

    @Override
    public void postInspect(AtmosphereResource r) {
    }

}