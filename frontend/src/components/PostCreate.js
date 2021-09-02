import React from 'react'
import { Create, SimpleForm, TextInput } from 'react-admin'
import { Field } from 'react-final-form';

const PostList = (props) => {
    return <Create title="Crie um post" {...props}>
       <SimpleForm>
            <Field label="" component="input" id='id' type="hidden"/>   
            <TextInput label="Marca" source='brand' />
            <TextInput label="Modelo" source='model' />
            <TextInput label="Nome "source='name' />
            <Field label="" component="input" id='user' type="hidden" value="1" />
       </SimpleForm>
    </Create>
}
export default PostList

