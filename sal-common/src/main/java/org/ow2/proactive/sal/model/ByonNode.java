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
package org.ow2.proactive.sal.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Representation of a BYON used by Cloudiator
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "BYON_NODE")
public class ByonNode extends AbstractNode {

    @Column(name = "NAME")
    @JsonProperty("name")
    private String name = null;

    @Embedded
    @JsonProperty("loginCredential")
    private LoginCredential loginCredential = null;

    @ElementCollection(targetClass = IpAddress.class)
    private List<IpAddress> ipAddresses = null;

    @Embedded
    @JsonProperty("nodeProperties")
    private NodeProperties nodeProperties = null;

    @Column(name = "REASON")
    @JsonProperty("reason")
    private String reason = null;

    @Column(name = "DIAGNOSTIC")
    @JsonProperty("diagnostic")
    private String diagnostic = null;

    @Column(name = "USER_ID")
    @JsonProperty("userId")
    private String userId = null;

    @Column(name = "ALLOCATED")
    @JsonProperty("allocated")
    private Boolean allocated = null;

    @Column(name = "JOB_ID")
    @JsonProperty("jobId")
    private String jobId;

    public ByonNode name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Human-readable name for the node.
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ByonNode loginCredential(LoginCredential loginCredential) {
        this.loginCredential = loginCredential;
        return this;
    }

    /**
     * Get loginCredential
     * @return loginCredential
     **/
    public LoginCredential getLoginCredential() {
        return loginCredential;
    }

    public void setLoginCredential(LoginCredential loginCredential) {
        this.loginCredential = loginCredential;
    }

    public ByonNode ipAddresses(List<IpAddress> ipAddresses) {
        this.ipAddresses = ipAddresses;
        return this;
    }

    public ByonNode addIpAddressesItem(IpAddress ipAddressesItem) {
        if (this.ipAddresses == null) {
            this.ipAddresses = new ArrayList<IpAddress>();
        }
        this.ipAddresses.add(ipAddressesItem);
        return this;
    }

    /**
     * The public/private ip addresses under which this node is reachable.
     * @return ipAddresses
     **/
    public List<IpAddress> getIpAddresses() {
        return ipAddresses;
    }

    public void setIpAddresses(List<IpAddress> ipAddresses) {
        this.ipAddresses = ipAddresses;
    }

    public ByonNode nodeProperties(NodeProperties nodeProperties) {
        this.nodeProperties = nodeProperties;
        return this;
    }

    /**
     * Further properties of this node.
     * @return nodeProperties
     **/
    public NodeProperties getNodeProperties() {
        return nodeProperties;
    }

    public void setNodeProperties(NodeProperties nodeProperties) {
        this.nodeProperties = nodeProperties;
    }

    public ByonNode reason(String reason) {
        this.reason = reason;
        return this;
    }

    public ByonNode diagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
        return this;
    }

    public ByonNode id(String id) {
        this.id = id;
        return this;
    }

    public ByonNode userId(String userId) {
        this.userId = userId;
        return this;
    }

    public ByonNode allocated(Boolean allocated) {
        this.allocated = allocated;
        return this;
    }

    /**
     * Signals if the node was allocated by cloudiator
     * @return allocated
     **/
    public Boolean isAllocated() {
        return allocated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ByonNode byonNode = (ByonNode) o;
        return Objects.equals(this.name, byonNode.name) &&
               Objects.equals(this.loginCredential, byonNode.loginCredential) &&
               Objects.equals(this.ipAddresses, byonNode.ipAddresses) &&
               Objects.equals(this.nodeProperties, byonNode.nodeProperties) &&
               Objects.equals(this.reason, byonNode.reason) && Objects.equals(this.diagnostic, byonNode.diagnostic) &&
               Objects.equals(this.nodeCandidate, byonNode.nodeCandidate) && Objects.equals(this.id, byonNode.id) &&
               Objects.equals(this.userId, byonNode.userId) && Objects.equals(this.allocated, byonNode.allocated) &&
               Objects.equals(this.jobId, byonNode.jobId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,
                            loginCredential,
                            ipAddresses,
                            nodeProperties,
                            reason,
                            diagnostic,
                            nodeCandidate,
                            id,
                            userId,
                            allocated);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ByonNode {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    loginCredential: ").append(toIndentedString(loginCredential)).append("\n");
        sb.append("    ipAddresses: ").append(toIndentedString(ipAddresses)).append("\n");
        sb.append("    nodeProperties: ").append(toIndentedString(nodeProperties)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    diagnostic: ").append(toIndentedString(diagnostic)).append("\n");
        sb.append("    nodeCandidate: ").append(toIndentedString(nodeCandidate)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
        sb.append("    allocated: ").append(toIndentedString(allocated)).append("\n");
        sb.append("    jobId: ").append(toIndentedString(jobId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
