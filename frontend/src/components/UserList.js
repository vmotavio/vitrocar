import React from 'react'
import {
    List,
    Datagrid,
    TextField,
    EditButton,
    DeleteButton,

} from 'react-admin'

const UserList = (props) => {
    return <List {...props}>
        <Datagrid>
            <TextField source='id' />
            <TextField source='username' />
            <EditButton basePath='/user' />
            <DeleteButton basePath='/user' />
        </Datagrid>
    </List>
}
export default UserList