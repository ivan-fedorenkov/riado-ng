<#import "../layout.ftl" as layout>
<#import "/spring.ftl" as s>

<@layout.entity_layout title="Адвокатские образования">
    <ul>
        <#list formations.content as formation>
            <li><a href='<@s.url "/formations/${formation.id}"/>'>${formation.name}</a></li>
        </#list>
    </ul>
</@layout.entity_layout>