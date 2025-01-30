CREATE TABLE IF NOT EXISTS restaurant_details (
    id UUID,
    code character varying(256),
    trade_name character varying(512),
    legal_name character varying(512),
    liquor_licence_number character varying(256),
    pan character varying(256),
    gst_number character varying(256),
    tin_no character varying(256),
    district_id int,
    division_id bigint,
    circle_id bigint,
    fl_licence_id character varying(256) UNIQUE,
    email character varying(256) UNIQUE,
    active boolean,
    created_by character varying(256),
    created_time bigint,
    last_modified_by character varying(256),
    last_modified_time bigint,
    CONSTRAINT pk_restaurant_details PRIMARY KEY (id)
    );
CREATE TABLE IF NOT EXISTS restaurant_audit_details (
    id UUID,
    code character varying(256),
    trade_name character varying(512),
    legal_name character varying(512),
    liquor_licence_number character varying(256),
    pan character varying(256),
    gst_number character varying(256),
    tin_no character varying(256),
    district_id int,
    division_id bigint,
    circle_id bigint,
    fl_licence_id character varying(256),
    active boolean,
    created_by character varying(256),
    created_time bigint,
    last_modified_by character varying(256),
    last_modified_time bigint
    );
COMMENT ON TABLE restaurant_details IS 'Table to store restaurant details';


