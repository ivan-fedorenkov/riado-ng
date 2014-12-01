<#import "../layout.ftl" as layout>
<#import "/spring.ftl" as s>

<@layout.entity_layout title="Адвокаты">
<ul>
    <#list lawyers as lawyer>
        <li><a href='<@s.url "/lawyers/${lawyer.id}"/>'>${lawyer.name}</a></li>
    </#list>
</ul>
</@layout.entity_layout>