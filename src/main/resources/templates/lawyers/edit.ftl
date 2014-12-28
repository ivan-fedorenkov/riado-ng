<#import "../layout.ftl" as layout>
<#import "form.ftl" as form>
<#import "/spring.ftl" as s>

<@layout.entity_layout "Адвокаты / Редактирование адвоката">
    <a href="<@s.url '/lawyers/${lawyer.id}'/>">Go back</a>
    <@form.form "/lawyers/${lawyer.id}" "patch" "Update!" />
</@layout.entity_layout>