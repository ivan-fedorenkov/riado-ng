<#import "../layout.ftl" as layout>
<#import "../utils.ftl" as utils>
<#import "/spring.ftl" as s>

<@layout.entity_layout "Адвокаты / Новый адвокат">
<a href="<@s.url '/chambers/${chamber.id}'/>">Go back</a>

<form action="<@s.url '/chambers/${chamber.id}/lawyers'/>" method="post">
    <p>
        Name: <@s.formInput "lawyer.name" />
        RegNum: <@s.formInput "lawyer.regNum" />
    </p>

    <p>
        <@utils.contacts_form "lawyer" />
    </p>

    <button type="submit">Create!</button>
</form>
</@layout.entity_layout>