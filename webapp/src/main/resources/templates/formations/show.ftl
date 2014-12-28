<#import "../layout.ftl" as layout>
<#import "/spring.ftl" as s>

<@layout.entity_layout title="${formation.name}">
    <p>
        <a href='<@s.url "/formations"/>'>Go back</a>
        <a href='<@s.url "/formations/${formation.id}/edit"/>'>Edit a formation</a>
        <a href='<@s.url "/chambers/${formation.id}"/>'>Delete a formation</a>
    </p>

    <h1>[${formation.id}] ${formation.name}</h1>

    <h2>Contacts:</h2>

    <#list formation.contacts as contact>
        <p>${contact.type} ${contact.value}</p>
    </#list>

    <h2>Lawyers:</h2>

    <#list formation.lawyers as lawyer>
        <p><a href='<@s.url "/lawyers/${lawyer.id}" />'>${lawyer.name}</a></p>
    </#list>

</@layout.entity_layout>