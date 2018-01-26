/*
 * The MIT License
 * Copyright (c) 2012 Microsoft Corporation
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package microsoft.exchange.webservices.data.dns;

import org.xbill.DNS.Lookup;
import org.xbill.DNS.Record;
import org.xbill.DNS.SRVRecord;
import org.xbill.DNS.Type;

import java.util.ArrayList;
import java.util.List;

import microsoft.exchange.webservices.data.core.exception.dns.DnsException;

/**
 * Class that represents DNS Query client.
 */
public class DnsClient {
    /**
     * Performs Dns query.
     *
     * @param <T>              the generic type
     * @param cls              DnsRecord Type
     * @param domain           the domain
     * @param dnsServerAddress IPAddress of DNS server to use (may be null)
     * @return DnsRecord The DNS record list (never null but may be empty)
     * @throws DnsException the dns exception
     */
    public static <T extends DnsRecord> List<T> dnsQuery(Class<T> cls, String domain, String dnsServerAddress) throws
            DnsException {
        System.out.println("dnsQuery(" + domain + ", " + dnsServerAddress + ")");
        List<T> dnsRecordList = new ArrayList<T>();

        try {
            Record[] records = new Lookup(domain, Type.SRV).run();
            if (records != null) {
                for (Record record : records) {
                    SRVRecord srvRecord = (SRVRecord) record;
                    System.err.println("dnsQuery() found: " + srvRecord.rdataToString());

                    T dnsRecord = cls.newInstance();

                    // Loads the DNS SRV record
                    dnsRecord.load(srvRecord.rdataToString());
                    dnsRecordList.add(dnsRecord);
                }
            } else {
                System.err.println("No results");
            }
        } catch (Exception e) {
            throw new DnsException(e.getMessage());
        }

        return dnsRecordList;
    }
}
