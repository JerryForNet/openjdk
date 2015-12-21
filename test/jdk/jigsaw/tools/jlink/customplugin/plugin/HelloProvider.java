/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jdk.tools.jlink.plugins.TransformerCmdProvider;
import jdk.tools.jlink.plugins.TransformerPlugin;
/**
 *
 * Strip Debug attributes plugin
 */
public final class HelloProvider extends TransformerCmdProvider {

    public static final String NAME = "hello";
    public static boolean called;

    public HelloProvider() {
        super(NAME, "Say Hello");
    }

    @Override
    public String getCategory() {
        return TRANSFORMER;
    }

    @Override
    public Map<String, String> getAdditionalOptions() {
        return null;
    }

    @Override
    public String getToolOption() {
        return NAME;
    }

    @Override
    public String getToolArgument() {
        return null;
    }

    @Override
    public List<TransformerPlugin> newPlugins(String[] arguments, Map<String, String> otherOptions) {
        List<TransformerPlugin> lst = new ArrayList<>();
        lst.add(new HelloPlugin());
        return lst;
    }

    @Override
    public Type getType() {
        return Type.RESOURCE_PLUGIN;
    }
}
