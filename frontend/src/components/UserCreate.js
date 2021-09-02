import React from 'react'
import { Create, SimpleForm, TextInput } from 'react-admin'

const UserList = (props) => {
    return <Create title="Crie um post" {...props}>
       <SimpleForm>
            <TextInput disabled source='id' />
            <TextInput source='username' />
            <TextInput source='password' type="password" />
       </SimpleForm>
    </Create>
}
export default UserList