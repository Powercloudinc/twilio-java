/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.sip.domain;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class CredentialListMappingCreator extends Creator<CredentialListMapping> {
    private String pathAccountSid;
    private final String pathDomainSid;
    private final String credentialListSid;

    /**
     * Construct a new CredentialListMappingCreator.
     *
     * @param pathDomainSid A string that identifies the SIP Domain for which the
     *                      CredentialList resource will be mapped
     * @param credentialListSid A string that identifies the CredentialList
     *                          resource to map to the SIP domain
     */
    public CredentialListMappingCreator(final String pathDomainSid,
                                        final String credentialListSid) {
        this.pathDomainSid = pathDomainSid;
        this.credentialListSid = credentialListSid;
    }

    /**
     * Construct a new CredentialListMappingCreator.
     *
     * @param pathAccountSid The unique sid that identifies this account
     * @param pathDomainSid A string that identifies the SIP Domain for which the
     *                      CredentialList resource will be mapped
     * @param credentialListSid A string that identifies the CredentialList
     *                          resource to map to the SIP domain
     */
    public CredentialListMappingCreator(final String pathAccountSid,
                                        final String pathDomainSid,
                                        final String credentialListSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathDomainSid = pathDomainSid;
        this.credentialListSid = credentialListSid;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created CredentialListMapping
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public CredentialListMapping create(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/SIP/Domains/" + this.pathDomainSid + "/CredentialListMappings.json"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("CredentialListMapping creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return CredentialListMapping.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (credentialListSid != null) {
            request.addPostParam("CredentialListSid", credentialListSid);
        }
    }
}