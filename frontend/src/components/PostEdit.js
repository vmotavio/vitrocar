import React from 'react'
import { Edit, SimpleForm, TextInput } from 'react-admin'
import { Field } from 'react-final-form';

const PostList = (props) => {
    return <Edit title="Edite um post" {...props}>
       <SimpleForm>
            <TextInput disabled source='id' />
            <TextInput label="Marca" source='brand' />
            <TextInput label="Modelo" source='model' />
            <TextInput label="Nome "source='name' />
            <Field label="" component="input" id='user' type="hidden" value="1" />
       </SimpleForm>
    </Edit>
}
export default PostList

