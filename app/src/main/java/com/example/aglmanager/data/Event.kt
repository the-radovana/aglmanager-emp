package com.example.aglmanager.data

import kotlinx.serialization.Serializable

@Serializable
data class EventResponse(
    val message: String,
    val data: EventDetails
)

@Serializable
data class EventsResponse(
    val data: List<EventList>
)

@Serializable
data class EventList(
    val id: Int,
    val title: String,
    val description: String,
    val startTime: String,
    val endTime: String,
    val published: Boolean,
    val assignedUsers: List<AssignedUser>,
    val status: String,
    val createdAt: String,
    val updatedAt: String
)

@Serializable
data class EventDetails(
    val id: Int,
    val title: String,
    val description: String,
    val startTime: String,
    val endTime: String,
    val location: Location,
    val client: Client,
    val published: Boolean,
    val equipment: List<Equipment>,
    val assignedUsers: List<AssignedUser>,
    val status: String,
    val createdBy: User,
    val inCharge: User,
    val professionRequirements: List<ProfessionRequirement>,
    val createdAt: String,
    val updatedAt: String
)

@Serializable
data class Location(
    val id: Int,
    val address: String,
    val city: String,
    val zipCode: String,
    val country: String,
    val createdAt: String,
    val updatedAt: String
)

@Serializable
data class Client(
    val id: Int,
    val company: String,
    val name: String,
    val email: String,
    val phone: String,
    val createdAt: String,
    val updatedAt: String
)

@Serializable
data class Equipment(
    val id: Int,
    val name: String,
    val category: Category,
    val eventId: Int,
    val createdAt: String,
    val updatedAt: String
)

@Serializable
data class Category(
    val id: Int,
    val name: String,
    val createdAt: String,
    val updatedAt: String
)

@Serializable
data class Profession(
    val id: Int,
    val title: String,
    val created_at: String? = null,
    val updated_at: String? = null
)

@Serializable
data class AssignedUser(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val role: String,
    val createdAt: String,
    val verifiedAt: String? = null,
    val profession: Profession
)

@Serializable
data class ProfessionRequirement(
    val id: Int,
    val count: Int,
    val payment: String,
    val profession: Profession,
    val createdAt: String,
    val updatedAt: String
)