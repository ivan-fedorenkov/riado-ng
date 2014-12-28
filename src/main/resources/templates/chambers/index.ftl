<#import "../layout.ftl" as layout>
<#import "/spring.ftl" as s>

<@layout.entity_layout title="Адвокатские палаты">
    <a href='<@s.url relativeUrl="/chambers/new"/>'>New chamber</a>

    <ul>
        <#list chambers.content as chamber>
            <li><a href='<@s.url "/chambers/${chamber.id}"/>'>${chamber.name}</a></li>
        </#list>
    </ul>
</@layout.entity_layout>