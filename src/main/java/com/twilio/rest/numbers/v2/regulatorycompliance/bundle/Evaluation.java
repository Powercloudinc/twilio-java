/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.numbers.v2.regulatorycompliance.bundle;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.Converter;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Evaluation extends Resource {
    private static final long serialVersionUID = 256422056466941L;

    public enum Status {
        COMPLIANT("compliant"),
        NONCOMPLIANT("noncompliant");

        private final String value;

        private Status(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Status from a string.
         * @param value string value
         * @return generated Status
         */
        @JsonCreator
        public static Status forValue(final String value) {
            return Promoter.enumFromString(value, Status.values());
        }
    }

    /**
     * Create a EvaluationCreator to execute create.
     *
     * @param pathBundleSid The bundle_sid
     * @return EvaluationCreator capable of executing the create
     */
    public static EvaluationCreator creator(final String pathBundleSid) {
        return new EvaluationCreator(pathBundleSid);
    }

    /**
     * Create a EvaluationReader to execute read.
     *
     * @param pathBundleSid The bundle_sid
     * @return EvaluationReader capable of executing the read
     */
    public static EvaluationReader reader(final String pathBundleSid) {
        return new EvaluationReader(pathBundleSid);
    }

    /**
     * Create a EvaluationFetcher to execute fetch.
     *
     * @param pathBundleSid The unique string that identifies the resource
     * @param pathSid The unique string that identifies the Evaluation resource
     * @return EvaluationFetcher capable of executing the fetch
     */
    public static EvaluationFetcher fetcher(final String pathBundleSid,
                                            final String pathSid) {
        return new EvaluationFetcher(pathBundleSid, pathSid);
    }

    /**
     * Converts a JSON String into a Evaluation object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Evaluation object represented by the provided JSON
     */
    public static Evaluation fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Evaluation.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Evaluation object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Evaluation object represented by the provided JSON
     */
    public static Evaluation fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Evaluation.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String regulationSid;
    private final String bundleSid;
    private final Evaluation.Status status;
    private final List<Map<String, Object>> results;
    private final DateTime dateCreated;
    private final URI url;

    @JsonCreator
    private Evaluation(@JsonProperty("sid")
                       final String sid,
                       @JsonProperty("account_sid")
                       final String accountSid,
                       @JsonProperty("regulation_sid")
                       final String regulationSid,
                       @JsonProperty("bundle_sid")
                       final String bundleSid,
                       @JsonProperty("status")
                       final Evaluation.Status status,
                       @JsonProperty("results")
                       final List<Map<String, Object>> results,
                       @JsonProperty("date_created")
                       final String dateCreated,
                       @JsonProperty("url")
                       final URI url) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.regulationSid = regulationSid;
        this.bundleSid = bundleSid;
        this.status = status;
        this.results = results;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.url = url;
    }

    /**
     * Returns The unique string that identifies the Evaluation resource.
     *
     * @return The unique string that identifies the Evaluation resource
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The SID of the Account that created the resource.
     *
     * @return The SID of the Account that created the resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The unique string of a regulation.
     *
     * @return The unique string of a regulation
     */
    public final String getRegulationSid() {
        return this.regulationSid;
    }

    /**
     * Returns The unique string that identifies the resource.
     *
     * @return The unique string that identifies the resource
     */
    public final String getBundleSid() {
        return this.bundleSid;
    }

    /**
     * Returns The compliance status of the Evaluation resource.
     *
     * @return The compliance status of the Evaluation resource
     */
    public final Evaluation.Status getStatus() {
        return this.status;
    }

    /**
     * Returns The results of the Evaluation resource.
     *
     * @return The results of the Evaluation resource
     */
    public final List<Map<String, Object>> getResults() {
        return this.results;
    }

    /**
     * Returns The date_created.
     *
     * @return The date_created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The url.
     *
     * @return The url
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Evaluation other = (Evaluation) o;

        return Objects.equals(sid, other.sid) &&
               Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(regulationSid, other.regulationSid) &&
               Objects.equals(bundleSid, other.bundleSid) &&
               Objects.equals(status, other.status) &&
               Objects.equals(results, other.results) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            accountSid,
                            regulationSid,
                            bundleSid,
                            status,
                            results,
                            dateCreated,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("accountSid", accountSid)
                          .add("regulationSid", regulationSid)
                          .add("bundleSid", bundleSid)
                          .add("status", status)
                          .add("results", results)
                          .add("dateCreated", dateCreated)
                          .add("url", url)
                          .toString();
    }
}