/*
 * ProActive Parallel Suite(TM):
 * The Open Source library for parallel and distributed
 * Workflows & Scheduling, Orchestration, Cloud Automation
 * and Big Data Analysis on Enterprise Grids & Clouds.
 *
 * Copyright (c) 2007 - 2017 ActiveEon
 * Contact: contact@activeeon.com
 *
 * This library is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation: version 3 of
 * the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * If needed, contact us to obtain a release under GPL Version 2 or 3
 * or a different license than the AGPL.
 */
package org.ow2.proactive.sal.service.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.ow2.proactive.sal.service.service.application.PAFactory;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Utils {

    private Utils() {
    }

    public static String getContentWithFileName(String fileName) {
        String script;
        String newLine = System.getProperty("line.separator");
        String scriptFileNameWithSeparator = (fileName.startsWith(File.separator)) ? fileName
                                                                                   : File.separator + fileName;
        LOGGER.debug("Creating a simple script from the file : " + scriptFileNameWithSeparator);
        try (Stream<String> lines = new BufferedReader(new InputStreamReader(PAFactory.class.getResourceAsStream(scriptFileNameWithSeparator))).lines()) {
            script = lines.collect(Collectors.joining(newLine));
        }
        return script;
    }
}