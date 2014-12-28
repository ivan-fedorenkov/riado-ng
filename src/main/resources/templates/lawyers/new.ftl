<#import "../layout.ftl" as layout>
<#import "form.ftl" as form>
<#import "/spring.ftl" as s>

<@layout.entity_layout "Адвокаты / Новый адвокат">
    <a href="<@s.url '/chambers/${chamber.id}'/>">Go back</a>
    <@form.form "/chambers/${chamber.id}/lawyers" "post" "Create!" />
</@layout.entity_layout>