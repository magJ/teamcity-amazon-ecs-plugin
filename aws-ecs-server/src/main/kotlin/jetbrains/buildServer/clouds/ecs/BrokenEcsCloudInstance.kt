/*
 * Copyright 2000-2020 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jetbrains.buildServer.clouds.ecs

import jetbrains.buildServer.clouds.CloudErrorInfo
import jetbrains.buildServer.clouds.InstanceStatus
import jetbrains.buildServer.clouds.ecs.apiConnector.EcsTask
import jetbrains.buildServer.serverSide.AgentDescription
import java.util.*

class BrokenEcsCloudInstance(private val instanceId: String,
                             private val cloudImage: EcsCloudImage,
                             private val errorInfo: CloudErrorInfo) : EcsCloudInstance {
    override fun update(task: EcsTask) {
        // do nothing
    }

    override val taskArn: String
        get() = ""

    private val startTime = Date()

    override fun terminate() {
        // do nothing
    }

    override fun getStatus() = InstanceStatus.ERROR

    override fun getInstanceId() = instanceId

    override fun getName() = instanceId

    override fun getStartedTime() = startTime

    override fun getImage() = cloudImage

    override fun getNetworkIdentity(): String? = null

    override fun getImageId() = cloudImage.id

    override fun getErrorInfo() = errorInfo

    override fun containsAgent(p0: AgentDescription) = false
}