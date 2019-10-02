/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.serverless.v1.service.environment;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
public class VariableCreator extends Creator<Variable> {
    private final String pathServiceSid;
    private final String pathEnvironmentSid;
    private final String key;
    private final String value;

    /**
     * Construct a new VariableCreator.
     *
     * @param pathServiceSid The SID of the Service to create the Variable resource
     *                       under
     * @param pathEnvironmentSid The SID of the environment in which the variable
     *                           exists
     * @param key A string by which the Variable resource can be referenced
     * @param value A string that contains the actual value of the variable
     */
    public VariableCreator(final String pathServiceSid,
                           final String pathEnvironmentSid,
                           final String key,
                           final String value) {
        this.pathServiceSid = pathServiceSid;
        this.pathEnvironmentSid = pathEnvironmentSid;
        this.key = key;
        this.value = value;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created Variable
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Variable create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.SERVERLESS.toString(),
            "/v1/Services/" + this.pathServiceSid + "/Environments/" + this.pathEnvironmentSid + "/Variables",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Variable creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return Variable.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (key != null) {
            request.addPostParam("Key", key);
        }

        if (value != null) {
            request.addPostParam("Value", value);
        }
    }
}