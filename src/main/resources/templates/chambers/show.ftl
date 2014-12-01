<#import "../layout.ftl" as layout>
<#import "/spring.ftl" as s>

<@layout.entity_layout title="${chamber.name}">
<p>
    <a href='<@s.url "/chambers"/>'>Go back</a>
    <a href='<@s.url "/chambers/${chamber.id}/edit"/>'>Edit chamber</a>
    <a href='<@s.url "/chambers/${chamber.id}"/>'>Delete chamber</a>
</p>
<p>
    <a href='<@s.url "/chambers/${chamber.id}/lawyers/new"/>'>Add a lawyer</a>
</p>

<h1>[${chamber.id}] ${chamber.name}</h1>

<h2>Contacts:</h2>
<#list chamber.contacts as contact>
    <p>${contact.type} ${contact.value}</p>
</#list>
</@layout.entity_layout>