/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.cassandra.cql3.functions;

import org.apache.cassandra.cql3.CQLTester;
import org.junit.Test;

public class GenericFctsTest extends CQLTester
{
    @Test
    public void testToStringFct() throws Throwable
    {
        createTable("CREATE TABLE %s (a int primary key, b text, c double)");
        execute("INSERT INTO %S (a, b, c) VALUES (1, '2', 3.0)");
        assertRows(execute("SELECT system.tostring(a), system.tostring(b), system.tostring(c) FROM %s"), row("1", (String) "2", "3.0"));
    }
    
    @Test
    public void testToJsonArrayFct() throws Throwable
    {
        createTable("CREATE TABLE %s (a int primary key, b text, c double)");
        execute("INSERT INTO %S (a, b, c) VALUES (1, '2', 3.0)");
        assertRows(execute("SELECT system.toJsonArray(a,b,c) FROM %s"), row("[1,\"2\",3.0]"));
    }
}
