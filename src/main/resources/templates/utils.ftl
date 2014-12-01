<#import "/spring.ftl" as s>

<#macro contacts_form entity_name>

    <input type="hidden" value="ADDRESS" name="contacts[0].type" />
    Address#1: <@s.formInput "${entity_name}.contacts[0].value" />

    <input type="hidden" value="PHONE" name="contacts[1].type" />
    Phone#1: <@s.formInput "${entity_name}.contacts[1].value" />

    <input type="hidden" value="WEBSITE" name="contacts[2].type" />
    Website#1: <@s.formInput "${entity_name}.contacts[2].value" />

    <input type="hidden" value="EMAIL" name="contacts[3].type" />
    Email#1: <@s.formInput "${entity_name}.contacts[3].value" />
</#macro>