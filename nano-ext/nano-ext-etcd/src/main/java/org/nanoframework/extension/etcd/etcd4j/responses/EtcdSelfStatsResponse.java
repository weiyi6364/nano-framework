/*
 * Copyright (c) 2015, Jurriaan Mous and contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nanoframework.extension.etcd.etcd4j.responses;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import static org.nanoframework.extension.etcd.etcd4j.EtcdUtil.convertDate;

/**
 * Etcd Self Stats response
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EtcdSelfStatsResponse implements EtcdResponse {

    // The json
    public static final EtcdResponseDecoder<EtcdSelfStatsResponse> DECODER = EtcdResponseDecoders.json(EtcdSelfStatsResponse.class);

    private final String id;
    private final String name;
    private final long recvAppendRequestCnt;
    private final double recvBandwidthRate;
    private final double recvPkgRate;
    private final long sendAppendRequestCnt;
    private final Date startTime;
    private final String state;
    private final LeaderInfo leaderInfo;

    EtcdSelfStatsResponse(@JsonProperty("id") String id, @JsonProperty("name") String name,
            @JsonProperty("recvAppendRequestCnt") long recvAppendRequestCnt, @JsonProperty("recvBandwidthRate") double recvBandwidthRate,
            @JsonProperty("recvPkgRate") double recvPkgRate, @JsonProperty("sendAppendRequestCnt") long sendAppendRequestCnt,
            @JsonProperty("startTime") String startTime, @JsonProperty("state") String state, @JsonProperty("leaderInfo") LeaderInfo leaderInfo) {
        this.id = id;
        this.name = name;
        this.recvAppendRequestCnt = recvAppendRequestCnt;
        this.recvBandwidthRate = recvBandwidthRate;
        this.recvPkgRate = recvPkgRate;
        this.sendAppendRequestCnt = sendAppendRequestCnt;
        this.state = state;
        this.leaderInfo = leaderInfo;
        this.startTime = convertDate(startTime);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getRecvAppendRequestCnt() {
        return recvAppendRequestCnt;
    }

    public double getRecvBandwidthRate() {
        return recvBandwidthRate;
    }

    public double getRecvPkgRate() {
        return recvPkgRate;
    }

    public long getSendAppendRequestCnt() {
        return sendAppendRequestCnt;
    }

    public Date getStartTime() {
        return startTime;
    }

    public String getState() {
        return state;
    }

    public LeaderInfo getLeaderInfo() {
        return leaderInfo;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LeaderInfo {

        private final String leader;
        private final Date startTime;
        private final String uptime;

        LeaderInfo(@JsonProperty("leader") String leader, @JsonProperty("startTime") String startTime, @JsonProperty("uptime") String uptime) {

            this.leader = leader;
            this.uptime = uptime;
            this.startTime = convertDate(startTime);
        }

        public String getLeader() {
            return leader;
        }

        public Date getStartTime() {
            return startTime;
        }

        public String getUptime() {
            return uptime;
        }
    }
}
