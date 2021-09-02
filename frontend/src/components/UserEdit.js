import React from 'react'
import { Edit, SimpleForm, TextInput } from 'react-admin'

const UserList = (props) => {
    return <Edit title="Edit um usuário" {...props}>
       <SimpleForm>
            <TextInput disabled source='id' />
            <TextInput source='username' />
            <TextInput source='password' type="password" />
       </SimpleForm>
    </Edit>
}
export default UserList