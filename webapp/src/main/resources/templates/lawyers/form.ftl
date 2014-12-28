<#import "../utils.ftl" as utils>
<#import "/spring.ftl" as s>

<#macro form url method button_title>
    <@utils.form url method>
        <p>
            Name: <@s.formInput "lawyer.name" />
            RegNum: <@s.formInput "lawyer.regNum" />
        </p>

        <p><@utils.contacts_form "lawyer" /></p>

        <button type="submit">${button_title}</button>
    </@utils.form>
</#macro>