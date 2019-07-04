create database jobcentral;
ALTER DATABASE news_database CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
use jobcentral;

create table nation(
	id int8 auto_increment primary key,
    nation_name nvarchar(50)
);

create table address(
	id int8 auto_increment primary key,
    address nvarchar(200) not null default '',
    nation_id int8 not null,
    user_id char(50),
    company_id char(50),
    account_verification_queue_id int8
);

create table user_category (
	id int8 auto_increment primary key,
    user_category_name nvarchar(50) not null
);

create table login_history (
	id int8 auto_increment primary key,
    accessToken text not null,
    is_remembered bit(1) default 0,
    user_id char(50) not null
);

create table app_user(
	id char(50) primary key,
    fullname nvarchar(100) not null,
    username char(20) not null,
    user_password char(100) not null,
    is_deleted bit(1) default 0,
    is_editable bit(1) default 0,
    phone_number char(15),
    email char(100),
    user_category_id int8 not null,
    company_id char(50) not null
);

create table app_role(
	id int8 auto_increment primary key,
    role_name char(50) not null
);

create table user_role(
	user_id char(50) not null,
    role_id int8 not null,
    primary key (user_id, role_id)
);

create table identity(
	id int8 primary key,
    number char(20) not null,
    image_1 char(100) not null,
    image_2 char(100) not null,
    user_id char(50) not null
);

create table type_of_business(
	id int8 auto_increment primary key,
    type_of_business_name nvarchar(100)
);

create table major(
	id int8 auto_increment primary key,
    major_name nvarchar(50),
    marjor_url char(50)
);

create table experience(
	id int8 auto_increment primary key,
    experience_name nvarchar(50),
    experience_url char(50)
);

create table tag(
	id int8 auto_increment primary key,
    tag_name nvarchar(50),
    tag_url nvarchar(50)
);

create table company(
	id char(50) primary key,
    company_name nvarchar(150) not null,
    summary nvarchar(200) not null,
    short_description nvarchar(300) not null,
    working_time char(100) not null,
    logo char(100) not null,
    type_of_business_id int8 not null,
    abbreviation char(10)
);

create table company_major(
	company_id char(50) not null,
    major_id int8 not null,
    primary key(company_id, major_id)
);

create table user_major(
	user_id char(50) not null,
    major_id int8 not null,
    primary key(user_id, major_id)
);

create table account_verification_queue(
	id int8 primary key,
    email char(50) not null,
    phone_number char(15) not null,
    identity_id int8 not null,
    user_id char(50) not null
);

create table assessor(
	id int8 primary key,
    fullname nvarchar(100) not null,
    email char(100) not null,
    company nvarchar(100) not null,
    current_position nvarchar(50) not null
);

create table evalution(
	id int8 primary key,
    major nvarchar(300) not null,
    communication nvarchar(300) not null,
    working_from Date not null,
    working_to Date not null,
    ability_of_development nvarchar(300) not null,
    other_evalutions nvarchar(300),
    access_code nvarchar(100),
    total_point8 float not null,
    assessor_id int8,
    active_time datetime,
    user_id char(50) not null
);

create table evalution_detail(
	id int8 primary key,
    point8 float not null,
    evalution nvarchar(100),
    evalution_id int8 not null,
    skill_name nvarchar(50)
);

create table skill(
	id int8 primary key,
    skill_name nvarchar(100) not null
);

create table skill_detail(
	id int8 primary key,
    skill_detail_name nvarchar(100) not null,
    skill_id int8 not null
);

create table evalution_skill(
	evalution_detail_id int8 not null,
    skill_detail_id int8 not null,
    primary key(evalution_detail_id, skill_detail_id)
);	

create table recruitment_post(
	id char(50) primary key,
    title nvarchar(100) not null default 'Tuyển dụng lập trình',
    expired_date date not null,
    short_description nvarchar(200) not null,
    offer_from int,
    offer_to int,
    requirement nvarchar(300) not null,
    benefit nvarchar(300) not null,
    recruitment_id char(50) not null
);

create table recruitment_post_major(
	recruitment_post_id char(50) not null,
    major_id int8 not null,
    primary key(recruitment_post_id, major_id)
);

create table recruitment_post_experience(
	recruitment_post_id char(50) not null ,
    experience_id int8 not null,
    primary key(recruitment_post_id, experience_id)
);

create table recruitment_post_tag(
	recruitment_post_id char(50) not null ,
    tag_id int8 not null ,
     primary key(recruitment_post_id, tag_id)
);

create table recruitment_post_skill(
	recruitment_post_id char(50) not null,
    skill_id int8 not null,
     primary key(recruitment_post_id, skill_id)
);

create table cv_template(
	id int8 primary key,
    template text not null,
    css text not null,
    thumpnail char(100),
    description_length int
);

create table cv(
	id int8 primary key,
    date_of_birth date not null,
    lastest_study_place nvarchar(100) not null,
    website char(100),
    short_description nvarchar(300) not null,
    cv_template_id int8,
    candidate_id char(50) not null
);

create table cv_skill(
	id int8 primary key,
    cv_skill_name nvarchar(50) not null,
    proficiency int8 not null,
    cv_id int8 not null
);

create table cv_education(
	id int8 primary key,
    cv_education_name nvarchar(100) not null,
    study_from date,
    study_to date,
    short_description nvarchar(150),
    cv_id int8 not null
);

create table cv_achievement(
	id int8 primary key,
    cv_achievement_name nvarchar(100) not null,
    in_date date,
    cv_id int8 not null
);

create table cv_work_experience(
	id int8 primary key,
    company_name nvarchar(100) not null,
    last_position nvarchar(50) not null,
    working_from date not null,
    working_to date,
    short_description nvarchar(150),
    cv_id int8 not null
);

create table cv_recruitment_post(
	cv_id int8 not null,
    recruitment_post_id char(50) not null,
    primary key(cv_id, recruitment_post_id)
);

-- foreign key
-- address
alter table address add foreign key (nation_id) references nation(id);
alter table address add foreign key (user_id) references app_user(id);
alter table address add foreign key (company_id) references company(id);
alter table address add foreign key (account_verification_queue_id) references account_verification_queue(id);

-- login_history
alter table login_history add foreign key (user_id) references app_user(id);

-- user role
alter table user_role add foreign key(user_id) references app_user(id);
alter table user_role add foreign key(role_id) references app_role(id);

-- app user
alter table app_user add foreign key (user_category_id) references user_category(id);
alter table app_user add foreign key (company_id) references company(id);

-- identity
alter table identity add foreign key (user_id) references app_user(id);

-- account_verification_queue
alter table account_verification_queue add foreign key (identity_id) references identity(id);
alter table account_verification_queue add foreign key (user_id) references app_user(id);

-- company
alter table company add foreign key (type_of_business_id) references type_of_business(id);

-- company_major
alter table company_major add foreign key (company_id) references company(id);
alter table company_major add foreign key (major_id) references major(id);

-- user_major
alter table user_major add foreign key (user_id) references app_user(id);
alter table user_major add foreign key (major_id) references major(id);

-- evalution
alter table evalution add foreign key(assessor_id) references assessor(id);
alter table evalution add foreign key(user_id) references app_user(id);

-- evalution_detail
alter table evalution_detail add foreign key(evalution_id) references evalution(id);

-- skill_detail
alter table skill_detail add foreign key(skill_id) references skill(id);

-- evalution_skill
alter table evalution_skill add foreign key(evalution_detail_id) references evalution_detail(id);
alter table evalution_skill add foreign key(skill_detail_id) references skill_detail(id);

-- recruitment_post
alter table recruitment_post add foreign key(recruitment_id) references app_user(id);

-- recruitment_post_major
alter table recruitment_post_major add foreign key(recruitment_post_id) references recruitment_post(id);
alter table recruitment_post_major add foreign key(major_id) references major(id);

-- recruitment_post_experience
alter table recruitment_post_experience add foreign key(recruitment_post_id) references recruitment_post(id);
alter table recruitment_post_experience add foreign key(experience_id) references experience(id);

-- recruitment_post_tag
alter table recruitment_post_tag add foreign key(recruitment_post_id) references recruitment_post(id);
alter table recruitment_post_tag add foreign key(tag_id) references tag(id);

-- recruitment_post_skill
alter table recruitment_post_skill add foreign key(recruitment_post_id) references recruitment_post(id);
alter table recruitment_post_skill add foreign key(skill_id) references skill(id);

-- cv
alter table cv add foreign key(cv_template_id) references cv_template(id);
alter table cv add foreign key(candidate_id) references app_user(id);

alter table cv_skill add foreign key(cv_id) references cv(id);
alter table cv_education add foreign key(cv_id) references cv(id);
alter table cv_achievement add foreign key(cv_id) references cv(id);
alter table cv_work_experience add foreign key(cv_id) references cv(id);

-- cv_recruitment_post
alter table cv_recruitment_post add foreign key(cv_id) references cv(id);
alter table cv_recruitment_post add foreign key(recruitment_post_id) references recruitment_post(id);

