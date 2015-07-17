/*
  Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.

  The MySQL Connector/J is licensed under the terms of the GPLv2
  <http://www.gnu.org/licenses/old-licenses/gpl-2.0.html>, like most MySQL Connectors.
  There are special exceptions to the terms and conditions of the GPLv2 as it is applied to
  this software, see the FLOSS License Exception
  <http://www.mysql.com/about/legal/licensing/foss-exception.html>.

  This program is free software; you can redistribute it and/or modify it under the terms
  of the GNU General Public License as published by the Free Software Foundation; version 2
  of the License.

  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
  See the GNU General Public License for more details.

  You should have received a copy of the GNU General Public License along with this
  program; if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth
  Floor, Boston, MA 02110-1301  USA

 */

package com.mysql.cj.mysqlx.devapi;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

import com.mysql.cj.api.x.Schema;
import com.mysql.cj.api.x.Session;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import com.mysql.cj.mysqlx.MysqlxSession;
import com.mysql.cj.mysqlx.io.AsyncMessageReader;
import com.mysql.cj.mysqlx.io.MessageWriter;
import com.mysql.cj.mysqlx.io.MysqlxProtocol;
import com.mysql.cj.mysqlx.io.MysqlxProtocolFactory;
import com.mysql.cj.mysqlx.io.SyncMessageWriter;

public class SessionImpl implements Session {
    private MysqlxSession session;
    private String defaultSchemaName;

    public SessionImpl(String host, int port, String user, String password, String database) {
        // TODO: prototype code until outer layers support parameters
        this.session = new MysqlxSession(MysqlxProtocolFactory.getAsyncInstance(host, port));
        this.session.changeUser(user, password, database);
        this.defaultSchemaName = database;
    }

    public Schema getSchemas() {
        throw new NullPointerException("TODO:");
    }

    public Schema getSchema(String name) {
        return new SchemaImpl(this, name);
    }

    public Schema getDefaultSchema() {
        return new SchemaImpl(this, this.defaultSchemaName);
    }

    public Schema createSchema(String name) {
        throw new NullPointerException("TODO:");
    }

    public Schema dropSchema(String name) {
        throw new NullPointerException("TODO:");
    }

    public String getUri() {
        throw new NullPointerException("TODO:");
    }

    public void close() {
        throw new NullPointerException("TODO:");
    }

    public MysqlxSession getMysqlxSession() {
        return this.session;
    }
}