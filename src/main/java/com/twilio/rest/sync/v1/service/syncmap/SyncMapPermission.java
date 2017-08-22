/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.sync.v1.service.syncmap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SyncMapPermission extends Resource {
    private static final long serialVersionUID = 261843483205862L;

    /**
     * Create a SyncMapPermissionFetcher to execute fetch.
     * 
     * @param pathServiceSid The service_sid
     * @param pathMapSid Sync Map SID or unique name.
     * @param pathIdentity Identity of the user to whom the Sync Map Permission
     *                     applies.
     * @return SyncMapPermissionFetcher capable of executing the fetch
     */
    public static SyncMapPermissionFetcher fetcher(final String pathServiceSid, 
                                                   final String pathMapSid, 
                                                   final String pathIdentity) {
        return new SyncMapPermissionFetcher(pathServiceSid, pathMapSid, pathIdentity);
    }

    /**
     * Create a SyncMapPermissionDeleter to execute delete.
     * 
     * @param pathServiceSid The service_sid
     * @param pathMapSid Sync Map SID or unique name.
     * @param pathIdentity Identity of the user to whom the Sync Map Permission
     *                     applies.
     * @return SyncMapPermissionDeleter capable of executing the delete
     */
    public static SyncMapPermissionDeleter deleter(final String pathServiceSid, 
                                                   final String pathMapSid, 
                                                   final String pathIdentity) {
        return new SyncMapPermissionDeleter(pathServiceSid, pathMapSid, pathIdentity);
    }

    /**
     * Create a SyncMapPermissionReader to execute read.
     * 
     * @param pathServiceSid The service_sid
     * @param pathMapSid Sync Map SID or unique name.
     * @return SyncMapPermissionReader capable of executing the read
     */
    public static SyncMapPermissionReader reader(final String pathServiceSid, 
                                                 final String pathMapSid) {
        return new SyncMapPermissionReader(pathServiceSid, pathMapSid);
    }

    /**
     * Create a SyncMapPermissionUpdater to execute update.
     * 
     * @param pathServiceSid Sync Service Instance SID or unique name.
     * @param pathMapSid Sync Map SID or unique name.
     * @param pathIdentity Identity of the user to whom the Sync Map Permission
     *                     applies.
     * @param read Read access.
     * @param write Write access.
     * @param manage Manage access.
     * @return SyncMapPermissionUpdater capable of executing the update
     */
    public static SyncMapPermissionUpdater updater(final String pathServiceSid, 
                                                   final String pathMapSid, 
                                                   final String pathIdentity, 
                                                   final Boolean read, 
                                                   final Boolean write, 
                                                   final Boolean manage) {
        return new SyncMapPermissionUpdater(pathServiceSid, pathMapSid, pathIdentity, read, write, manage);
    }

    /**
     * Converts a JSON String into a SyncMapPermission object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return SyncMapPermission object represented by the provided JSON
     */
    public static SyncMapPermission fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, SyncMapPermission.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a SyncMapPermission object using the
     * provided ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return SyncMapPermission object represented by the provided JSON
     */
    public static SyncMapPermission fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, SyncMapPermission.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String serviceSid;
    private final String mapSid;
    private final String identity;
    private final Boolean read;
    private final Boolean write;
    private final Boolean manage;
    private final URI url;

    @JsonCreator
    private SyncMapPermission(@JsonProperty("account_sid")
                              final String accountSid, 
                              @JsonProperty("service_sid")
                              final String serviceSid, 
                              @JsonProperty("map_sid")
                              final String mapSid, 
                              @JsonProperty("identity")
                              final String identity, 
                              @JsonProperty("read")
                              final Boolean read, 
                              @JsonProperty("write")
                              final Boolean write, 
                              @JsonProperty("manage")
                              final Boolean manage, 
                              @JsonProperty("url")
                              final URI url) {
        this.accountSid = accountSid;
        this.serviceSid = serviceSid;
        this.mapSid = mapSid;
        this.identity = identity;
        this.read = read;
        this.write = write;
        this.manage = manage;
        this.url = url;
    }

    /**
     * Returns The Twilio Account SID..
     * 
     * @return Twilio Account SID.
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The Sync Service Instance SID..
     * 
     * @return Sync Service Instance SID.
     */
    public final String getServiceSid() {
        return this.serviceSid;
    }

    /**
     * Returns The Sync Map SID..
     * 
     * @return Sync Map SID.
     */
    public final String getMapSid() {
        return this.mapSid;
    }

    /**
     * Returns The Identity of the user to whom the Sync Map Permission applies..
     * 
     * @return Identity of the user to whom the Sync Map Permission applies.
     */
    public final String getIdentity() {
        return this.identity;
    }

    /**
     * Returns The Read access..
     * 
     * @return Read access.
     */
    public final Boolean getRead() {
        return this.read;
    }

    /**
     * Returns The Write access..
     * 
     * @return Write access.
     */
    public final Boolean getWrite() {
        return this.write;
    }

    /**
     * Returns The Manage access..
     * 
     * @return Manage access.
     */
    public final Boolean getManage() {
        return this.manage;
    }

    /**
     * Returns The URL of this Sync Map Permission..
     * 
     * @return URL of this Sync Map Permission.
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

        SyncMapPermission other = (SyncMapPermission) o;

        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(serviceSid, other.serviceSid) && 
               Objects.equals(mapSid, other.mapSid) && 
               Objects.equals(identity, other.identity) && 
               Objects.equals(read, other.read) && 
               Objects.equals(write, other.write) && 
               Objects.equals(manage, other.manage) && 
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            serviceSid,
                            mapSid,
                            identity,
                            read,
                            write,
                            manage,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("serviceSid", serviceSid)
                          .add("mapSid", mapSid)
                          .add("identity", identity)
                          .add("read", read)
                          .add("write", write)
                          .add("manage", manage)
                          .add("url", url)
                          .toString();
    }
}