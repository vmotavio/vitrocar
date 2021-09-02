import React from 'react'
import {
    List,
    Datagrid,
    TextField,
    EditButton,
    DeleteButton,

} from 'react-admin'

const PostList = (props) => {
    return <List {...props} title="Carros">
        <Datagrid>
            <TextField source='id' />
            <TextField source='name' />
            <TextField source='model' />
            <TextField source='brand' />
            <EditButton basePath='/car' />
            <DeleteButton basePath='/car' />
        </Datagrid>
    </List>
}
export default PostList