<#import "../layout.ftl" as layout>
<#import "../utils.ftl" as utils>
<#import "/spring.ftl" as s>

<@layout.entity_layout "Адвокатские палаты / Новая палата">
<a href="<@s.url '/chambers'/>">Go back</a>

<form action="<@s.url '/chambers'/>" method="post">

    <p>
        Name: <@s.formInput "chamber.name" />
    </p>

    <p>
        <@utils.contacts_form "chamber" />
    </p>

    <button type="submit">Create!</button>
</form>
</@layout.entity_layout>