<#import "../layout.ftl" as layout>
<#import "../utils.ftl" as utils>
<#import "/spring.ftl" as s>

<@layout.entity_layout "Адвокатские образования / Новое адвокатское образование">
    <a href="<@s.url '/chambers/${chamber.id}'/>">Go back</a>

    <form action="<@s.url '/chambers/${chamber.id}/formations'/>" method="post">
        <p>
            Name: <@s.formInput "formation.name" />
            Type: <@s.formSingleSelect "formation.form" formationForms />
        </p>

        <p>
            <@utils.contacts_form "formation" />
        </p>

        <button type="submit">Create!</button>
    </form>
</@layout.entity_layout>