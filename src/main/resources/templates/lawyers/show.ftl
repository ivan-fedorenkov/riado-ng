<#import "../layout.ftl" as layout>
<#import "/spring.ftl" as s>

<@layout.entity_layout title="${lawyer.name}">
<p>
    <a href='<@s.url "/lawyers"/>'>Go back</a>
    <a href='<@s.url "/lawyers/${lawyer.id}/edit"/>'>Edit a lawyer</a>
    <a href='<@s.url "/chambers/${lawyer.id}"/>'>Delete a lawyer</a>
</p>

<h1>[${lawyer.id}] ${lawyer.name}</h1>

<h2>Contacts:</h2>
    <#list lawyer.contacts as contact>
    <p>${contact.type} ${contact.value}</p>
    </#list>
</@layout.entity_layout>